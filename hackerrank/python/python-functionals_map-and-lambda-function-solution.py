cube = lambda x: x**3

fib_dict = {}

def fibonacci(n):
    if n > 0:
        calc_fibonacci(n)
    return list(fib_dict.values())
    
def calc_fibonacci(n):
    if n == 1:
        return fib_dict.setdefault(n, n - 1)
    elif n == 2:
        fib_dict.setdefault(n - 1, n - 2)    
        return fib_dict.setdefault(n, n - 1)
    else:
        return fib_dict.setdefault(n, calc_fibonacci(n - 2) + calc_fibonacci(n - 1))

if __name__ == '__main__':
    n = int(input())
    print(list(map(cube, fibonacci(n))))
