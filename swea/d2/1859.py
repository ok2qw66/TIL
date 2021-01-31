T = int(input())

for test_case in range(1, T + 1):
    length = int(input())
    stack_list = list(map(int, input().split()))
    temp = stack_list[-1]
    answer = 0

    # 1번
    # while stack_list:
    #     max_idx = stack_list.index(max(stack_list))
    #     # 처음이 가장 큰값 => 이득 없음
    #     if max_idx == 0:
    #         break
    #     else:
    #         max_val = stack_list[max_idx]
    #         # max_val 이전 값들만 max_val과 차이만큼 answer에 더한다
    #         for val in stack_list[:max_idx]:
    #             answer += max_val - val
    #         # stack_list은 그 다음 인덱스부터 끝까지로 재세팅
    #         stack_list = stack_list[max_idx+1:]   


    # 2번
    # for idx in range(len(stack_list) - 1):
    #     answer += max(max(stack_list[idx+1:]) - stack_list[idx], 0)


    for idx in range(len(stack_list)-2, -1, -1):
        if temp >= stack_list[idx]:
            answer += temp - stack_list[idx]
        else:
            temp = stack_list[idx]
    print('#{} {}'.format(test_case, answer))