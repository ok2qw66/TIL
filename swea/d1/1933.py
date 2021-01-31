num = int(input())
answer = [str(i) for i in range(1, num+1) if not num % i]
print(' '.join(answer))