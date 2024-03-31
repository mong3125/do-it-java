import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
temp = list
answer = 0

def mergeSort(start, end):
    global answer, arr

    if (end - start < 1):
        return
    
    mid = (end + start) // 2
    mergeSort(start, mid)
    mergeSort(mid + 1, end)

    index = start
    i = start
    j = mid + 1
    temp = []

    while (i <= mid and j <= end):
        if (arr[i] > arr[j]):
            temp.append(arr[j])
            answer += (mid - i) + 1
            j += 1
        else:
            temp.append(arr[i])
            i += 1

    if (i <= mid):
        temp += arr[i:mid+1]
    if (j <= end):
        temp += arr[j:end+1]
    
    for i in range(len(temp)):
        arr[start+i] = temp[i]

mergeSort(0, len(arr) - 1)
print(answer)