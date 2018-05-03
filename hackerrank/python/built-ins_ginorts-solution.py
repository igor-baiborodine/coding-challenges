string = list(input().strip())
lower = [s for s in string if s.islower()]
upper = [s for s in string if s.isupper()]
odd_digits = [int(s) for s in string if s.isnumeric() and int(s) % 2 == 1]
even_digits = [int(s) for s in string if s.isnumeric() and int(s) % 2 == 0]
print(''.join(sorted(lower) + sorted(upper) + [str(d) for d in sorted(odd_digits)] + [str(d) for d in sorted(even_digits)]))
