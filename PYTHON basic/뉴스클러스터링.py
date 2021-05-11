def solution(str1, str2):
    dict1 = {}
    dict2 = {}
    
    for x,y in zip(str1,str1[1:]):
        key = (x+y).lower()
        if not key.isalpha(): continue
        dict1[key] = dict1.get(key,0)+1
        
    for x,y in zip(str2,str2[1:]):
        key = (x+y).lower()
        if not key.isalpha(): continue
        dict2[key] = dict2.get(key,0)+1
        
    intersect,union = checkInter(dict1, dict2)
    #print(dict2)
    union += checkUnion(dict2)
    print(union)
    if union == 0:
        return 65536
    return int((intersect/union) * 65536)

    
def checkInter(dict1, dict2):
    intersect = 0
    union = 0
    for key, val in dict1.items():
        #print("Val",val)
        if dict2.get(key,0) != 0 :
            val2 = dict2.pop(key)
            #print("val2",val2)
            intersect += min(val, val2)
            union += max(val, val2)
        else:
            union += val
    return intersect,union

def checkUnion(dict2):
    union = 0
    for val in dict2.values():
        union += val
    return union
