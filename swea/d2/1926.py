number = int(input())

for num in range(1, number + 1):
    count = str(num).count('3') + str(num).count('6') + str(num).count('9')

    if count:
        print('-' * count, end=' ')
    else:
        print(str(num), end=' ')