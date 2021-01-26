//
//  ViewController.swift
//  MatchEmNav
//
//  Created by Charlie on 12/12/20.
//

import UIKit

enum FadeStyle {
    case fade
    case slide
}

class GameSceneVC: UIViewController {
    
    // MARK: - ==== Config Properties ====
    //================================================
    // Min and max width and height for the rectangles
    private let rectSizeMin:CGFloat =  50.0
    private let rectSizeMax:CGFloat = 150.0
    
    // How long for the rectangle to fade away
    private var fadeDuration: TimeInterval = 0.8
    
    // Game duration, time remaining
    var gameDuration: TimeInterval = 12.0
    private lazy var gameTimeRemaining = gameDuration

    // Random transparency on or off
    private var randomAlpha = false
    
    // Rects have colors or are gray
    var coloredRect = true
    
    // Rectangle creation interval
    var newRectInterval: TimeInterval = 1.2
    
    //
    var disappearStyle = FadeStyle.slide
    
    // MARK: - ==== Internal Properties ====
    @IBOutlet weak var gameInfoLabel: UILabel!
    
    private var gameInfo : String {
        let labelText = "Total: \(rectanglesCreated) - Touched \(rectanglesTouched)"
        return labelText
    }
    
    // Keep track of all rectangles created
    private var rectangles = [UIButton]()
    
    // Rectangle creation, so the timer can be stopped
    private var newRectTimer: Timer?
    
    // Game timer
    private var gameTimer: Timer?
    
    // Keep track of: 1. Is there a game going?, 2. Running or paused?
    private var gameInProgress = false
    private var gameRunning    = false
    
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
        
        view.isMultipleTouchEnabled = true
    }
    
    //================================================
    override func viewWillAppear(_ animated: Bool) {
        // Don't forget the call to super in these methods
        super.viewWillAppear(animated)
          
        //
        if gameInProgress {
            resumeGameRunning()
        }
    }
    
    //================================================
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        
        //
        if gameInProgress {
            pauseGameRunning()
        }
    }
    
    //================================================
    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
        // Two finger touch required
        if touches.count != 2 {
            return
        }
            
        // If no game is in progress start a new game
        if !gameInProgress {
            startNewGame()
            return
        }
            
        // We have a game in progress, pause or resume?
        if gameRunning {
            pauseGameRunning()
        } else {
            resumeGameRunning()
        }
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
extension GameSceneVC {
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
        var randomColor = UIColor.gray
        
        if(coloredRect){
            randomColor = Utility.getRandomColor(randomAlpha: randomAlpha)
        }
        // Create a rectangle
        //let rectangleFrame = CGRect(x: 50, y: 150, width: 180, height: 140)
        
        //============Rect 1=============
        let rectangle = UIButton(frame: randomFrame)
        rectanglesCreated += 1
        
        // Save the rectangle till the game is over
        rectangles.append(rectangle)
            
        // Do some button/rectangle setup
        //rectangle.backgroundColor = .green
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
        
        //============Rect 2=============
        let rectangle2 = UIButton(frame: randomFrame2)
        rectanglesCreated += 1
        
        // Save the rectangle till the game is over
        rectangles.append(rectangle2)
            
        // Do some button/rectangle setup
        //rectangle.backgroundColor = .green
        rectangle2.backgroundColor = randomColor
        /*if(coloredRect){
            rectangle2.backgroundColor = Utility.getRandomColor(randomAlpha: randomAlpha)
        } else{
            rectangle2.backgroundColor = UIColor.gray
        }*/

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
        
        //===============================
        
        // Move label to the front
        view.bringSubviewToFront(gameInfoLabel!)
        
        //add pair to dictionary
        rectPairs[rectangle] = rectangle2
        rectPairs[rectangle2] = rectangle
        
        // Count down ...
        gameTimeRemaining -= newRectInterval
    }
    
    //================================================
    func removeRectangle(rectangle: UIButton) {
        
        switch disappearStyle {
        case .fade:
            // Rectangle fade animation
            let pa = UIViewPropertyAnimator(duration: fadeDuration,
                                            curve: .easeInOut,
                                            animations: nil)
            
            pa.addAnimations {
                rectangle.alpha = 0.0
            }
            pa.startAnimation()
        case .slide:
            // Remove buttons with slide off to right and disappear
            let buttonFrameEnd   = CGRect(x: view.bounds.size.width, y: 50,
                                          width: 80, height: 50)
            
            let pa = UIViewPropertyAnimator(duration: 2.0,
                                            curve: .linear,
                                            animations: nil)
            pa.addAnimations {
                rectangle.alpha = 0.0
                rectangle.frame = buttonFrameEnd
            }
            pa.startAnimation()
        }
        
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
extension GameSceneVC {
    //================================================
    func startNewGame() {
        // Clear the rectangles
        removeSavedRectangles()

        // Reset the time remaing to the full game time
        gameTimeRemaining = gameDuration
        
        // Reset the game stat vars
        rectanglesCreated = 0
        rectanglesTouched = 0
        
        // Adjust the label background
        gameInfoLabel.backgroundColor = .clear

        // Game operation
        gameInProgress = true
        
        //
        resumeGameRunning()
    }
    
    //================================================
    func gameOver() {
        pauseGameRunning()
        
        // No game in progress, and thus no game running
        gameInProgress = false
            
        // Indicate via the label the game is over
        gameInfoLabel.backgroundColor = .red
    }
    
    //================================================
    private func resumeGameRunning()
    {
        // Indicate that the game is now running
        gameRunning = true
        
        // Set the label
        gameInfoLabel.text = gameInfo

        // Timer to produce the pairs
        newRectTimer = Timer.scheduledTimer(withTimeInterval: newRectInterval,
                                                     repeats: true)
                                            { _ in self.createRectangle() }
        
        // Timer to end the game, resume with the remaining time
        gameTimer = Timer.scheduledTimer(withTimeInterval: gameTimeRemaining,
                                                  repeats: false)
                                            { _ in self.gameOver() }
    }
    
    //================================================
    private func pauseGameRunning() {
        // Indicate that the game is paused
        gameRunning = false
            
        // Set the label
        gameInfoLabel.text = gameInfo

        // Stop the timers
        newRectTimer?.invalidate()
        gameTimer?.invalidate()
            
        // Remove the reference to the timer objects
        newRectTimer = nil
        gameTimer    = nil
    }
}

