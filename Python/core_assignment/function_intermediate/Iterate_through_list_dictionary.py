students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]


def iterateDictionary(students):
    for student in students:
        output_str = "first_name - " + student['first_name'] + ", " + "last_name - " + student['last_name']
        print(output_str)
    
iterateDictionary(students)



def iterateDictionary2(key_name, some_list):
    for student in students:
        print (student[key_name])
iterateDictionary2('first_name', students)







dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}





def printInfo(some_dict):
    x = (len(dojo['locations']))
    print(f"{x} LOCATIONS")
    for location in dojo['locations']: 
        print(location)
    y = (len(dojo['instructors']))
    print(f"{y} INSTRUCTORS")
    for instructor in dojo['instructors']:
        print(instructor)
printInfo(dojo)


