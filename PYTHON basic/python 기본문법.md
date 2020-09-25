# 파이썬을 파이썬답게



### 1. 몫과 나머지

```python
a, b = map(int, input().strip().split(' '))

print(*divmod(a, b))
```

- a,b 를 입력받기
- divmod(a,b) ==> 몫과 나머지 순으로 출력