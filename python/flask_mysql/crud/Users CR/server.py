from flask import Flask, render_template, redirect, request

app=Flask(__name__)


@app.route('/')
def main():
    return render_template("read.html")



if __name__=="__main__":
    app.run(debug = True)