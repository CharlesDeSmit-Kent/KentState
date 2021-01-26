//
//  HighScoresVC.swift
//  RRTableProject
//
//  Created by Charlie on 12/13/20.
//

import UIKit


class HighScoreVC: UITableViewController{
    private let sectionRowCount = 3
    private let tableSectionCount = 1
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return sectionRowCount
    }
    override func numberOfSections(in tableView: UITableView) -> Int {
        return tableSectionCount
    }
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "stuffCell", for: indexPath)
            
        cell.textLabel?.text = "High Score Foo"
        
        return cell
    }
    
}
