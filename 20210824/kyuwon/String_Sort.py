# 문자열 재정렬       기출 : Facebook 인터뷰
# 알파벳 대문자와 숫자(0~9)로만 구성된 문자열이 입력으로 주어짐.
# 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤 ,
# 그 뒤에 모든 숫자를 더한 값을 이어서 출력
# EX) 입력 : K1KA5CB7 =>  출력: ABCKK13
# 아이디어 : ASCII 로 알파벳 대문자면 리스트에 받아서 정렬 , 숫자면 합치기
# ord : ASCII로 변환 , chr: 문자로 반환
# 알파벳 대문자 : A~Z (65~90) , 0~9 (48~57)

n = input()
result = []  # 알파벳 담을 리스트 => 결과
digit = 0   # 숫자 계산

for i in n:
    if ord(i) >= 65 and ord(i) <= 90:   # 알파벳 대문자
        result.append(i)
    elif ord(i) >= 48 and ord(i) <= 57: # 숫자
        digit += int(i)
# 알파벳 정렬
result.sort()
# 숫자담기
result.append(str(digit))

print(''.join(result))

# 파이썬에는 알파벳 판별 함수가 내장되어있다.
# 파이썬에 내장되어 있는 함수를 아직 많이 모르는거 같다.

result2 = []
digit2 = 0

for i in n:
    if i.isalpha():
        result2.append(i)
    else:
        digit2 += int(i)
# 알파벳 정렬
result2.sort()
result2.append(str(digit2))

print(''.join(result2))


