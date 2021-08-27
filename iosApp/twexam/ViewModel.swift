//
//  ViewModel.swift
//  twexam
//
//  Created by Jayden Lee on 25/08/2021.
//

import Foundation
import shared

class ViewModel: ObservableObject {
  @Published var members = [MemberModel]()
  @Published var isError = false

   private let network :NetworkApi
  
  init(network: NetworkApi) {
    self.network = network
  }
  
  func fetch() {
//    let dispatchGroup = DispatchGroup()
//
//    dispatchGroup.enter()
    //show loading
    DispatchQueue.main.async {
        self.network.getMembers(){
            Result, Error in
            if Result != nil{
                print(Result!)
//                dispatchGroup.leave()
                //stop loading
            } else {
                print(Error!)
//                dispatchGroup.leave()
                //stop loading
            }
        }
    }
  }
    
    func insertToDatabase(){
        let sharedDb = Database(databaseDriverFactory : DatabaseDriverFactory())
        sharedDb.insert(it: "testing")
    }
    
    func getFromDatabase(){
        let sharedDb = Database(databaseDriverFactory : DatabaseDriverFactory())
        print(sharedDb.getData())
    }
}
