for x1 in range (0,151,1):
    print(x1)
for x2 in range(5,1000):
    if x2%5==0:
        print(x2)
for x3 in range (1,101):
    if x3%10==0:
        print("Coding Dojo")
        continue
    elif x3%5==0:
        print("Coding")
        continue
    else :
        print(x3)
sum=0   
for x4 in range (0,500000):
    if x4%2!=0:
        sum=+x4
print(sum)
for x5 in range (2018,0,-4):
    print (x5)
    
lowNum=0
highNum=100
mult=15
for m in range (lowNum,highNum):
    if m % mult==0:
        print(m)
        