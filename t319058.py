def RPN(N):
    operator = {
        "+" : (lambda x, y: x + y),
        "-" : (lambda x, y: x - y),
        "*" : (lambda x, y: x * y),
        "/" : (lambda x, y: float(x) / y)
        }
    stack = []
    N = N.split()
    for i in N:
        if i.isdigit():
            stack.append(int(i))
        else:
            y = stack.pop()
            x = stack.pop()
            stack.append(operator[i](x,y))
    return stack[0]

#main
N = "10 5 3 * +"
print(RPN(N))
    
