# # 1- Update Values in Dictionaries and Lists
# x = [ [5,2,3], [10,8,9] ] 
# students = [
#     {'first_name':  'Michael', 'last_name' : 'Jordan'},
#     {'first_name' : 'John', 'last_name' : 'Rosales'}
# ]
# sports_directory = {
#     'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
#     'soccer' : ['Messi', 'Ronaldo', 'Rooney']
# }
# z = [ {'x': 10, 'y': 20} ]

# x[1][0]=15
# print(x[1][0])
# students[0]['last_name']='Bryant'
# print(students[0]['last_name'])
# sports_directory['soccer'][0]='Andres'
# print(sports_directory['soccer'][0])
# z[0]['y']=30
# print(z)

# 2 Iterate Through a List of Dictionaries
# def iterateDictionary(m):
#     for x in range(0,len(m)):
#         hk=m[x]['first_name']
#         hv=m[x]['last_name']
#         print(f"fisrt_name - {hk} , last_name - {hv}")

# students = [
#         {'first_name':  'Michael', 'last_name' : 'Jordan'},
#         {'first_name' : 'John', 'last_name' : 'Rosales'},
#         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
#         {'first_name' : 'KB', 'last_name' : 'Tonel'}
#     ]
# iterateDictionary(students) 
# # should output: (it's okay if each key-value pair ends up on 2 separate lines;
# # bonus to get them to appear exactly as below!)
# # first_name - Michael, last_name - Jordan
# # first_name - John, last_name - Rosales
# # first_name - Mark, last_name - Guillen
# # first_name - KB, last_name - Tonel

# # 3 Get Values From a List of Dictionaries

# def iterateDictionary2(key_name, some_list):
#     for x in range (0,len(some_list)):
#         print(f"{some_list[0][key_name]}")
# iterateDictionary2('last_name', students)

# 4 Iterate Through a Dictionary with List Values

def printInfo(some_dict):
    for x in some_dict:
        l=len(some_dict[x])
        print(f"\n{l} {x}" )
        for y in range (0,l):
            print(f"{some_dict[x][y]}")
        
dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
printInfo(dojo)
