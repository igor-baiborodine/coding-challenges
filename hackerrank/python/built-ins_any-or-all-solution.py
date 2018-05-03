n, ints = (int(input()), input().split())
positive, palindrom = ([int(i) > 0 for i in ints], [i == i[::-1] for i in ints])
print(all(positive) and any(palindrom))