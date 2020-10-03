# 파이썬을 파이썬답게

참고 : https://wikidocs.net/20464

### input :  eval() 함수 사용 - 유효한 파이썬 표현식으로 리턴

```python
data = int(input("정수를 입력하시오 : "))

# eval() 사용
string = eval( input("(1,2) 처럼입력하시오 "))
print(string, type(string))    # (1, 2) <class 'tuple'>


# 변수 2개이상 입력받기
a,b = map(int, input().strip().split(' '))

# 리스트 형태로 입력받기
data = list(map(int, input().strip().split(' ')))
```



### declare : 리스트 선언

```python
# 1차원 리스트 선언

# 2차원 리스트 선언 : 6 * 5 행렬 : row 행 / col 열
array = [[0] for col in range(6) for row in range(5)]
array = [[0]*6 for i in range(5)]
array = [[0]*11]*10
```



### map(funtion,<iterable>)

```python
# a요소를 정수로 바꾸기
# map(함수, 리스트 or 튜플의 변수명)
a = [1.5 , 1.9 , 13.5]
b = list(map(int, a))
print(b)
```



###  split

```python
x = "i am student, you are a girl"
b= x.split()  # 괄호안에 어떤 문자를 기준으로 분리할지 적습니다. 없으면 공백으로 분리
print(b)
```



------





### 1. 몫과 나머지 - divmod

###### divmod(a,b) ==> 몫(a/b)과 나머지(a%b) 순으로 출력

```python
# a, b를 입력받기
a, b = map(int, input().strip().split(' '))

print(*divmod(a, b))
```



### 2. n진법으로 표기된 string을 10진법 숫자로 변환하기 - int 함수

###### int(x , base = 10)  ==> string x 를 10진법 숫자로 변환한다

```python
num = '3212'
base = 5

# '3212' 를 5진법 숫자로 바꿈
answer = int(num, base)
```



### 3. 문자열 정렬하기 -  ljust, center, rjust

```python
s = '가나다라'
n = 7

s.ljust(n) # 좌측 정렬
s.center(n) # 가운데 정렬
s.rjust(n) # 우측 정렬
```



### 4. 알파벳 출력하기 - string 모듈

```python
import string 

string.ascii_lowercase # 소문자 abcdefghijklmnopqrstuvwxyz
string.ascii_uppercase # 대문자 ABCDEFGHIJKLMNOPQRSTUVWXYZ
string.ascii_letters #대소문자 모두 abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
string.digits # 숫자 0123456789
```



### 5.  sequence 멤버를 하나로 이어붙이기 - join

```python
my_list = ['1', '100', '33']
answer = ''.join(my_list)   # 110033
answer2 = '/'.join(my_list) # 1/100/33
```



### 6. 원본을 유지한 채, 정렬된 리스트 구하기 - sorted

```python
list1 = [3, 2, 1]
list2 = sorted(list1)
```



### 7. 2차원 리스트 뒤집기 - zip

```python
mylist = [[1,2,3], [4,5,6], [7,8,9]]
# new_list = list(map(list, zip(mylist[0],mylist[1],mylist[2]))) 와 같은 의미
new_list = list(map(list, zip(*mylist)))   # [[1,4,7], [2,5,8], [3,6,9]]

animals = ['cat', 'dog', 'lion']
sounds = ['meow', 'woof', 'roar']
answer = dict(zip(animals, sounds)) # {'cat': 'meow', 'dog': 'woof', 'lion': 'roar'}
```



### 8. 모든 멤버의 type 변환하기 - map

```python
list1 = ['1', '100', '33']
list2 = list(map(int, list1))
```



### 9. sequence type의 * 연산 : n번 반복

```python
n = 숫자
answer= [123, 456]*n
```



### 10.  sequence 멤버를 하나로 이어붙이기 - join

```python
my_list = ['1', '100', '33']
answer = ''.join(my_list)   # 110033
answer2 = '/'.join(my_list) # 1/100/33
```



### 11. 2차원 리스트를 1차원 리스트로 만들기 - from_iterable

```python
my_list = [[1, 2], [3, 4], [5, 6]]

# 방법 1 - sum 함수
answer = sum(my_list, [])

# 방법 2 - itertools.chain
import itertools
list(itertools.chain.from_iterable(my_list))

# 방법 3 - itertools와 unpacking
import itertools
list(itertools.chain(*my_list))

# 방법4 - list comprehension 이용
[element for array in my_list for element in array]

# 방법 5 - reduce 함수 이용1
from functools import reduce
list(reduce(lambda x, y: x+y, my_list))

# 방법 6 - reduce 함수 이용2
from functools import reduce
import operator
list(reduce(operator.add, my_list))

# 방법 7 - numpy 라이브러리의 flatten 이용
import numpy as np
np.array(my_list).flatten().tolist()
```



### 12. 가장 많이 등장하는 알파벳 찾기 - Counter

```python
import collections
my_list = [1, 2, 3, 4, 5, 6, 7, 8, 7, 9, 1, 2, 3, 3, 5, 2, 6, 8, 9, 0, 1, 1, 4, 7, 0]
answer = collections.Counter(my_list)

print(answer[1]) # = 4
print(answer[3])  # = 3
print(answer[100]) # = 0
```





### 13. List comprehension

```python
mylist = [3, 2, 6, 7]
answer = [ i**2 for i in mylist if i %2 == 0]
```



### 14. for -else 문 : for 에 해당이 안되면 else로 적용한다

```python
import math
numbers = [int(input()) for _ in range(5)]
multiplied = 1
for number in numbers:
    multiplied *= number
    if math.sqrt(multiplied) == int(math.sqrt(multiplied)):
        print('found')
        break
else:
    print('not found')
```



### 15. swap

```python
a = 3
b = 'abc'
a,b = b,a
```



### 16. 이진 탐색하기 - binary search

```python
import bisect
mylist = [1, 2, 3, 7, 9, 11, 33]
print(bisect.bisect(mylist, 3))


# 다른 언어로 작성시에 참고
def bisect(a, x, lo=0, hi=None):
    if lo < 0:
        raise ValueError('lo must be non-negative')
    if hi is None:
        hi = len(a)
    while lo < hi:
        mid = (lo + hi) // 2
        if a[mid] < x:
            lo = mid + 1
        else:
            hi = mid
    return lo
```



### 17. 클래스 인스턴스 출력하기 - class의 자동 string casting

```python
# 파이썬에서는 __str__ 메소드를 사용해 class 내부에서 출력 format을 지정할 수 있습니다.

class Coord(object):
    def __init__ (self, x, y):
        self.x, self.y = x, y
    def __str__ (self):
        return '({}, {})'.format(self.x, self.y)

point = Coord(1, 2)
```



### 18. 가장 큰 수, inf

```python
# 파이썬이 제공하는 inf 를 사용해보세요. inf는 어떤 숫자와 비교해도 무조건 크다고 판정됩니다.

min_val = float('inf')
min_val > 10000000000

#inf에는 음수 기호를 붙이는 것도 가능합니다.
max_val = float('-inf')
```



### 19. 파일 입출력

```python
# 파일을 close 하지 않아도 됩니다: with - as 블록이 종료되면 파일이 자동으로 close 됩니다.
# readlines가 EOF까지만 읽으므로, while 문 안에서 EOF를 체크할 필요가 없습니다.

with open('myfile.txt') as file:
  for line in file.readlines():
    print(line.strip().split('\t'))
```


