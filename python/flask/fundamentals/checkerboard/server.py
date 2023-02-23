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



if __name__=='__main__':
    app.run(debug=True)