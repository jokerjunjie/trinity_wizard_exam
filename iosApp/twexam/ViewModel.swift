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
  
//    private let repository: MembersRepo
    private let network :NetworkApi
  
  init(network: NetworkApi) {
    self.network = network
  }
  
  func fetch() {
    network.getMembers(){
        Result, Error in
        if Result != nil{
            print(Result!)
        } else {
            print(Error!)
        }
    }
  }
}
