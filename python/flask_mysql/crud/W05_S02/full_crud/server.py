from flask import Flask , render_template, redirect , request
from singer_model import Singer

app = Flask(__name__)

@app.route('/')
def home():
    all_singers = Singer.get_all()
    return render_template("index.html" , all_singers = all_singers)

@app.route('/singers/new')
def new_singer():
    return render_template("new_singer.html")

@app.route('/singers/create', methods=['post'])
def create_singer():
    print(request.form, "****")
    Singer.create(request.form)
    return redirect('/')

if __name__ == '__main__':
    app.run(debug = True, port = 5003)