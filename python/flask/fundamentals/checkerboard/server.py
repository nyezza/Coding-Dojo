from flask import Flask, render_template
app=Flask(__name__)

@app.route('/')
def home():
    
    return render_template('home.html')

@app.route ('/<int:row>')
def simple_dim(row):
    return render_template('index.html',y=row//2)

@app.route('/<int:row>/<int:col>')
def double_dim(row,col):
    return render_template('index.html',y=row,x=col)

@app.route('/<int:row>/<int:col>/<string:color1>/<string:color2>')
def bonus(row,col,color1,color2):
    return render_template('index.html',y=row,x=col,color1=color1,color2=color2)



if __name__=='__main__':
    app.run(debug=True)