import string

upper_alpha = string.ascii_uppercase
lower_alpha = string.ascii_lowercase

sentence = str(input())
new_sentence = ''

for idx in range(len(sentence)):
    if sentence[idx] in lower_alpha:
        lower = sentence[idx]
        lower_idx = lower_alpha.index(lower)
        new_sentence += upper_alpha[lower_idx]
    else:
        new_sentence += sentence[idx]

print(new_sentence)