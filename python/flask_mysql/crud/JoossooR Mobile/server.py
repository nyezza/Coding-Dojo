from flask import Flask, render_template, request, redirect
from user_model import User
app=Flask(__name__)

@app.route('/')
def main():
    return redirect('/all')

@app.route('/all')
def Read_all():
    all_porters=User.get_all()
    return render_template("index.html", porter_list=all_porters)

@app.route('/porter/new')
def new():
    return render_template("new.html")

@app.route('/porter/create',methods=['post'])
def create():
    User.create(request.form)
    return redirect('/')

@app.route ('/porter/<int:user_id>')
def get_one(user_id):
    data={
        "id":user_id
    }
    one_porter = User.get_one(data)
    return render_template("view.html", one_user=one_porter)
    
@app.route('/porter/update/<int:user_id>')
def update_by_id(user_id):
    update_one=User.get_one({"id":user_id})
    return render_template("update.html",one_user=update_one)

@app.route('/porter/update',methods=['post'])
def update():
    print(request.form)
    User.update(request.form)
    return redirect('/')
    







if __name__=="__main__":
    app.run(debug = True)