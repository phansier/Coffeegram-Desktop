import SwiftUI
import common

class ObservableViewStateModel: ObservableObject {
    private var navStore: NavigationStoreAdapter?
    @Published
    var viewState: NavigationState?
    
    func activate() {
        navStore = NavigationStoreAdapter { [weak self] viewState in
             self?.viewState = viewState
         }
     }
    func deactivate() {
         //viewModel?.onDestroy()
        navStore = nil
    }
    
    func test() {
        navStore?.doNewIntent(intent: NavigationIntent.NextMonth())
    }
}

struct ContentView: View {
	let greet = "Hello there"//Greeting().greeting()
    
    @ObservedObject
    var observableModel = ObservableViewStateModel()

	var body: some View {
		Text(greet)
        Text(YearMonthKt.nowYM().getFullMonthName() + " " + String(YearMonthKt.nowYM().year))
        Text(observableModel.viewState?.yearMonth.getFullMonthName() ?? "")
            .onAppear(perform: {
                 observableModel.activate()
             })
        Button("Test", action: observableModel.test)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
