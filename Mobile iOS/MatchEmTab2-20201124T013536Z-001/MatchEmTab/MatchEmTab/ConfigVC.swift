//
//  ConfigVC.swift
//  RandomRectanglesTab
//
//  Created by Charlie on 11/21/20.
//  Copyright © 2020 Emanon. All rights reserved.
//

import UIKit

class ConfigVC: UIViewController {
    var gameSceneVC: GameSceneVC?
    
    @IBOutlet weak var speedSlider: UISlider!
    @IBOutlet weak var speedValue: UILabel!
    @IBOutlet weak var BGController: UISegmentedControl!
    @IBOutlet weak var RectColor: UISegmentedControl!
    @IBOutlet weak var timeSlider: UISlider!
    @IBOutlet weak var timeValue: UILabel!
    
    var speedValueLabelMessage: String {
        return String(format: "%.1f", speedSlider.value / speedSlider.maximumValue * 100.0)
    }
    var timeValueLabelMessage: String {
        return String(format: "%.1f", timeSlider.value / timeSlider.maximumValue * 100.0)
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Set up a reference to the game scene
        gameSceneVC = self.tabBarController!.viewControllers![0] as? GameSceneVC
        
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        //
        speedSetUp()
        timeSetUp()
    }
    
    func speedSetUp() {
        // Speed slider range
        speedSlider.minimumValue = 0.4
        speedSlider.maximumValue = 3.0

        // Get the current speed
        let currentDelay = Float((gameSceneVC?.newRectInterval)!)
                                
        // Init the slider position from the game scene
        speedSlider.value = currentDelay
                                                        
        // Init the slider's value label, depends on slider.value
        speedValue.text = speedValueLabelMessage

    }
    
    func timeSetUp() {
        // Time slider range
        timeSlider.minimumValue = 2.0
        timeSlider.maximumValue = 24.0

        // Get the current time
        let currentTime = Float((gameSceneVC?.gameDuration)!)
                                
        // Init the slider position from the game scene
        timeSlider.value = currentTime
                                                        
        // Init the slider's value label, depends on slider.value
        timeValue.text = timeValueLabelMessage
    }
    
    @IBAction func speedSlider(_ sender: UISlider) {
        // UPDATE THE SPEED IN THE GameSceneVC object
        gameSceneVC?.newRectInterval = TimeInterval(speedSlider.value)
                                
        // Update the slider's value label
        speedValue.text = speedValueLabelMessage
    }
    @IBAction func BGController(_ sender: UISegmentedControl) {
        
        //sets background color to white or black
        switch BGController.selectedSegmentIndex
        {
        case 0:
            gameSceneVC?.view.backgroundColor = .white
            
        case 1:
            gameSceneVC?.view.backgroundColor = .black
            
        default:
            break
        }
        
    }
    @IBAction func RectColor(_ sender: UISegmentedControl) {
        
        //Changes whether rectangles have colors or are gray
        switch RectColor.selectedSegmentIndex
        {
        case 0:
            gameSceneVC?.coloredRect = true
            
        case 1:
            gameSceneVC?.coloredRect = false

        default:
            break
        }
    }
    
    @IBAction func timeSlider(_ sender: UISlider) {
        // Update time in the GameSceneVC object
        gameSceneVC?.gameDuration = TimeInterval(timeSlider.value)
                                
        // Update the slider's value label
        timeValue.text = timeValueLabelMessage
    }
    
}
