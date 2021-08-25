//
//  TableViewCell.swift
//  twexam
//
//  Created by Jayden Lee on 25/08/2021.
//

import UIKit

class TableViewCell: UITableViewCell {

    @IBOutlet weak var ivPfp: UIImageView!
    @IBOutlet weak var lblDesc: UITextView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func setupCell(){
        lblDesc.text = "Testing 123"
    }
    
}
