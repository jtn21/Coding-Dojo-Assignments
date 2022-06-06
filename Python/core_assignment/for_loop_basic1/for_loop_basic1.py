for x in range( 0, 151):
    print (x)

for y in range( 5, 1001, 5):
    print (y)

for z in range ( 1, 101):
    if (z % 10) == 0:
        print ("Coding Dojo")
    elif ( z % 5 ) == 0:
        print ("Coding")
    else: print (z)

total = 0
for num in range ( 0, 500001):
    if (num % 2) == 1:
        total += num
print( total )


for a in range ( 2018, 0, -4):
    print (a)

lowNum = 2
highNum = 10
mult = 3

for num in range ( lowNum, highNum):
    if num % mult == 0:
        print (num)