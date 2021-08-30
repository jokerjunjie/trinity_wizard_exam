//
//  ViewController.swift
//  twexam
//
//  Created by Jayden Lee on 25/08/2021.
//

import UIKit
import shared

class ViewController: UIViewController {

    @IBOutlet weak var tableView: UITableView!
    
    var viewModel = ViewModel(network: NetworkApi())
    
    override func viewDidLoad() {
        super.viewDidLoad()
//        self.viewModel.fetch()
        
        tableView.register(UINib(nibName: "TableViewCell", bundle: nil), forCellReuseIdentifier: "TableViewCell")
        tableView.delegate = self
        tableView.dataSource = self

        print(NSLocalizedString("internet_error", tableName: "", bundle: Bundle.main, value: "", comment: ""))
//        self.viewModel.insertToDatabase()
//        self.viewModel.getFromDatabase()
    }
}

extension ViewController : UITableViewDelegate, UITableViewDataSource{
    
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 5
    }
    
    
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "TableViewCell", for: indexPath) as? TableViewCell
        else {
         fatalError("DequeueReusableCell failed while casting")
        }
         cell.setupCell()
         return cell
    }
}

