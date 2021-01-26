//
//  ViewController.swift
//  MatchEmScene
//
//  Created by Charlie on 10/31/20.
//

import UIKit

class GameSceneViewController: UIViewController {
    // MARK: - ==== Config Properties ====
    //================================================
    // Min and max width and height for the rectangles
    private let rectSizeMin:CGFloat =  50.0
    private let rectSizeMax:CGFloat = 150.0
    
    // How long for the rectangle to fade away
    private var fadeDuration: TimeInterval = 0.8
    
    // Game duration
    private var gameDuration: TimeInterval = 12.0
    
    //Game time remaining
    private lazy var gameTimeRemaining = gameDuration
    
    // Random transparency on or off
    private var randomAlpha = false
    
    // Rectangle creation interval
    private var newRectInterval: TimeInterval = 1.2
    
    // MARK: - ==== Internal Properties ====

    @IBOutlet weak var gameInfoLabel: UILabel!
    private var gameInfo : String {
        let labelText = String(format: "Time: %2.1f Created: %2d Touch: %2d",
                               gameTimeRemaining, rectanglesCreated, rectanglesTouched)
        
        return labelText
    }
    
    // Keep track of all rectangles created
    private var rectangles = [UIButton]()
    
    // Rectangle creation, so the timer can be stopped
    private var newRectTimer: Timer?
    
    // Game timer
    private var gameTimer: Timer?
    
    // A game is in progress
    private var gameInProgress = false
    
    // Counters, property observers used
    private var rectanglesCreated = 0 {
        didSet { gameInfoLabel?.text = gameInfo } }
    private var rectanglesTouched = 0 {
        didSet { gameInfoLabel?.text = gameInfo } }
    
    //Dictionry
    private var rectPairs: [UIButton: UIButton] = [:]
    
    // Stores first button pressed
    private var firstRectTouched: UIButton?

    // MARK: - ==== View Controller Methods ====
    //================================================
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
    }
    
    //================================================
    override func viewWillAppear(_ animated: Bool) {
        // Don't forget the call to super in these methods
        super.viewWillAppear(animated)
                        
        // Create rectangles
        startGameRunning()
    }
    
    //================================================
    @objc private func handleTouch(sender: UIButton) {
        if !gameInProgress {
            return
        }
        
        //print("\(#function) - \(sender)")
        // Check if sender is the first or second rect
        if firstRectTouched != nil{
            //If they're a pair, highlight and remove squares
            if rectPairs[firstRectTouched!] == sender{
                sender.setTitle("🐹", for: .normal)
                rectPairs[firstRectTouched!] = nil
                rectPairs[sender] = nil
                removeRectangle(rectangle: firstRectTouched!)
                removeRectangle(rectangle: sender)
            //else unhighlight first rect and unmark it as first
            }else{
                firstRectTouched!.setTitle("", for: .normal)
            }
            firstRectTouched = nil
        //if not second, highlight and make the first press
        }else{
            firstRectTouched = sender
            sender.setTitle("🐹", for: .normal)
        }
        
        //
        rectanglesTouched += 1
    }
    
    //================================================
    override var prefersStatusBarHidden: Bool {
               return true
    }
}

// MARK: - ==== Rectangle Methods ====
extension GameSceneViewController {
    //================================================
    private func createRectangle() {
        // Get random values for size and location
        let randSize     = Utility.getRandomSize(fromMin: rectSizeMin,
                                                 throughMax: rectSizeMax)
        let randLocation = Utility.getRandomLocation(size: randSize,
                                                     screenSize: view.bounds.size)
        let randLocation2 = Utility.getRandomLocation(size: randSize,
                                                     screenSize: view.bounds.size)
        let randomFrame  = CGRect(origin: randLocation, size: randSize)
        
        let randomFrame2  = CGRect(origin: randLocation2, size: randSize)
        
        let randomColor = Utility.getRandomColor(randomAlpha: randomAlpha)
        
        // Create a rectangle
        //let rectangleFrame = CGRect(x: 50, y: 150, width: 180, height: 140)
        let rectangle = UIButton(frame: randomFrame)
        rectanglesCreated += 1
        
        // Save the rectangle till the game is over
        rectangles.append(rectangle)
            
        // Do some button/rectangle setup
        //rectangle.backgroundColor = .green
        //rectangle.backgroundColor = Utility.getRandomColor(randomAlpha: randomAlpha)
        rectangle.backgroundColor = randomColor
        
        rectangle.setTitle("", for: .normal)
        rectangle.setTitleColor(.black, for: .normal)
        rectangle.titleLabel?.font = .systemFont(ofSize: 50)
        rectangle.showsTouchWhenHighlighted = true
        
        // Target/action to set up connect of button to the VC
        rectangle.addTarget(self,
                         action: #selector(self.handleTouch(sender:)),
                         for: .touchUpInside)
            
        // Make the rectangle visible
        self.view.addSubview(rectangle)
        
        //=======================Rectangle 2=========================
        
        let rectangle2 = UIButton(frame: randomFrame2)
        rectanglesCreated += 1
        
        // Save the rectangle till the game is over
        rectangles.append(rectangle2)
            
        // Do some button/rectangle setup
        //rectangle.backgroundColor = .green
        //rectangle.backgroundColor = Utility.getRandomColor(randomAlpha: randomAlpha)
        rectangle2.backgroundColor = randomColor
        
        rectangle2.setTitle("", for: .normal)
        rectangle2.setTitleColor(.black, for: .normal)
        rectangle2.titleLabel?.font = .systemFont(ofSize: 50)
        rectangle2.showsTouchWhenHighlighted = true
        
        // Target/action to set up connect of button to the VC
        rectangle2.addTarget(self,
                         action: #selector(self.handleTouch(sender:)),
                         for: .touchUpInside)
            
        // Make the rectangle visible
        self.view.addSubview(rectangle2)
        
        // Move label to the front
        view.bringSubviewToFront(gameInfoLabel!)
        //add pair to dictionary
        rectPairs[rectangle] = rectangle2
        rectPairs[rectangle2] = rectangle
        
        //decrement timer
        gameTimeRemaining -= newRectInterval

    }
    
    //================================================
    func removeRectangle(rectangle: UIButton) {
        // Rectangle fade animation
        let pa = UIViewPropertyAnimator(duration: fadeDuration,
                                        curve: .easeInOut,
                                      animations: nil)
        
        pa.addAnimations {
            rectangle.alpha = 0.0
        }
        pa.startAnimation()
    }
    
    //================================================
    func removeSavedRectangles() {
        // Remove all rectangles from superview
        for rectangle in rectangles {
            rectangle.removeFromSuperview()
        }
        
        // Clear the rectangles array
        rectangles.removeAll()
    }
}

// MARK: - ==== Timer Functions ====
extension GameSceneViewController {
    //================================================
    private func startGameRunning()
    {
        //
        removeSavedRectangles()
        
        // Timer to produce the rectangles
        newRectTimer = Timer.scheduledTimer(withTimeInterval: newRectInterval,
                                     repeats: true)
                                     { _ in self.createRectangle() }
        
        // Timer to end the game
        gameTimer = Timer.scheduledTimer(withTimeInterval: gameDuration,
                                                  repeats: false)
                                   { _ in self.stopGameRunning() }
        
        gameInProgress = true
    }
    
    //================================================
    private func stopGameRunning() {
        // Stop the timer
        if let timer = newRectTimer { timer.invalidate() }

        // Remove the reference to the timer object
        self.newRectTimer = nil
        
        //
        gameInProgress = false

    }
}
