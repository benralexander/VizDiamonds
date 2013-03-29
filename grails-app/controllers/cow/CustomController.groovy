package cow

class CustomController {

    def custom_diamond() {
        render(view: 'custom_diamond')
    }
    def test() {
        render(view: 'test')
    }
    def index(){
        render(view: 'custom_diamond')
    }

}
