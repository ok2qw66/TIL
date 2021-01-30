import string 

lower_alpha = string.ascii_lowercase 
upper_alpha = string.ascii_uppercase

T = str(input())
answer = []
for t in T:
    if t in lower_alpha:
        answer.append(str(lower_alpha.index(t) + 1))
    else:
        answer.append(str(upper_alpha.index(t) + 1))

print(' '.join(answer))