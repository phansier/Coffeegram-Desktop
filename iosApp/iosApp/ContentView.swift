import SwiftUI
import common

struct ContentView: View {
	let greet = "Hello there"//Greeting().greeting()

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

// class ObservableViewStateModel: ObservableObject {
//     private var viewModel: MpViewmodel?
//
//     @Published
//     var viewState: ViewState?
//
//     func activate() {
//         viewModel = MpViewmodel { [weak self] viewState in
//             self?.viewState = viewState
//         }
//         viewModel?.getFilms()
//     }
//
//     func deactivate() {
//         //viewModel?.onDestroy()
//         viewModel = nil
//     }
//
// }
//
// struct ViewStateScreen: View {
//     @ObservedObject
//     var observableModel = ObservableViewStateModel()
//
//     var body: some View {
//         Text(observableModel.viewState?.value ?? "null")
//             .onAppear(perform: {
//                 observableModel.activate()
//             }
//         )
//     }
// }
