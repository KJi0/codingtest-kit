# 기여 가이드 (Contributing Guide)

SSAFY 코딩테스트 스터디 공동 레포지토리입니다.
매주 [프로그래머스 고득점 Kit](https://school.programmers.co.kr/learn/challenges?tab=algorithm_practice_kit)의 한 유형을 풀고 PR로 제출합니다.

## 🔧 최초 세팅 (1회만)

```bash
# 1. GitHub에서 이 레포를 Fork

# 2. 내 fork를 clone
git clone https://github.com/{내-계정}/codingtest-kit.git
cd codingtest-kit

# 3. 원본 레포를 upstream으로 등록
git remote add upstream https://github.com/{organization}/codingtest-kit.git

# 확인
git remote -v
# origin    https://github.com/{내-계정}/codingtest-kit.git   (fetch/push)
# upstream  https://github.com/{organization}/codingtest-kit.git (fetch/push)
```

## 🔄 매주 워크플로우

### Step 1. 최신 상태로 동기화
```bash
git checkout main
git fetch upstream
git merge upstream/main
```

### Step 2. 작업 브랜치 생성
```bash
git checkout -b week01/오명헌
```

### Step 3. 자기 폴더에 풀이 작성
```
week01_hash/오명헌/
├── 42576_완주하지_못한_선수.py
├── 1845_폰켓몬.py
├── 42577_전화번호_목록.py
├── 42578_의상.py
└── 42579_베스트앨범.py
```

### Step 4. Commit & Push
```bash
git add week01_hash/오명헌/
git commit -m "[week01] 해시 - 완주하지 못한 선수, 폰켓몬"
git push origin week01/오명헌
```

### Step 5. Pull Request 생성
GitHub에서 `내-fork:week01/오명헌` → `organization:main` 으로 PR을 엽니다.

## 📝 코드 작성 규칙

### 파일명
```
{문제번호}_{문제이름}.{확장자}

✅ 42576_완주하지_못한_선수.py
✅ 42586_기능개발.java
❌ solution1.py
❌ 완주하지못한선수.py
```

문제번호는 URL 끝의 숫자입니다.
`https://school.programmers.co.kr/learn/courses/30/lessons/`**`42576`**

### 파일 상단 주석 (필수)
- 문제 이름 + 레벨
- 문제 URL
- 시간복잡도 / 공간복잡도
- 풀이 접근 방식 한두 줄

### Python 예시
```python
"""
완주하지 못한 선수 (Lv.1)
https://school.programmers.co.kr/learn/courses/30/lessons/42576

시간복잡도: O(n)
공간복잡도: O(n)
풀이: 참가자 이름의 빈도를 세고 완주자만큼 차감하면 남는 이름이 정답.
      동명이인이 있으므로 set 차집합으로는 풀 수 없다.
"""
from collections import Counter


def solution(participant, completion):
    return (Counter(participant) - Counter(completion)).most_common(1)[0][0]
```

### Java 예시
```java
/*
 * 완주하지 못한 선수 (Lv.1)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 * 풀이: HashMap으로 이름별 카운트를 세고, 완주자를 차감해 남는 이름을 찾는다.
 */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();
        for (String p : participant) count.merge(p, 1, Integer::sum);
        for (String c : completion)  count.merge(c, -1, Integer::sum);

        for (Map.Entry<String, Integer> e : count.entrySet()) {
            if (e.getValue() > 0) return e.getKey();
        }
        return "";
    }
}
```

## 📋 PR 템플릿

```markdown
## 🎯 주차 정보
- **주차**: Week 01 - 해시
- **완료 문제**: 5 / 5

## 📝 풀이 요약
| 문제 | 레벨 | 접근 방식 | 소요 시간 |
|---|:---:|---|---|
| 완주하지 못한 선수 | 1 | 해시맵 빈도 차감 | 10분 |
| 폰켓몬 | 1 | set 크기와 N/2 중 최소 | 5분 |
| 전화번호 목록 | 2 | 정렬 후 인접 접두사 비교 | 25분 |
| 의상 | 2 | 종류별 (개수+1) 곱 - 1 | 20분 |
| 베스트앨범 | 3 | 장르 집계 후 다중 조건 정렬 | 45분 |

## 💭 어려웠던 부분
{막혔던 지점과 해결 과정}

## 🙋 질문 / 리뷰 요청
{리뷰어에게 특별히 봐줬으면 하는 부분}
```

## 🔍 코드 리뷰 가이드

### 리뷰할 때 볼 것
- [ ] 시간/공간복잡도가 명시되어 있는가
- [ ] 문제의 입력 제한을 고려한 복잡도인가
- [ ] 변수명이 의미를 드러내는가
- [ ] 엣지 케이스를 처리하는가
- [ ] 더 간결하거나 빠른 접근이 있는가

### 리뷰 댓글 예시
```markdown
✅ **좋은 점**
단조 스택으로 O(n)에 푼 게 깔끔합니다.

💡 **제안**
`dict.get(k, 0) + 1` 대신 `Counter`를 쓰면 의도가 더 잘 드러날 것 같아요.

❓ **질문**
여기서 `right`를 `min(times) * n`으로 잡은 이유가 궁금합니다.
```

## 🤝 리뷰 문화

**리뷰하는 사람** — 건설적인 피드백, 다양한 풀이 존중, 구체적인 개선안 제시
**리뷰받는 사람** — 피드백에 감사, 적극적인 토론, 배운 점을 다음 주에 적용

## ⏰ 일정

| 항목 | 마감 |
|---|---|
| 문제 풀이 + PR 제출 | 매주 **일요일 23:59** |
| 코드 리뷰 완료 | 매주 **월요일 18:00** |
| PR 병합 | 매주 **화요일** |

## ✅ PR 제출 전 체크리스트

- [ ] `upstream/main`과 동기화했는가
- [ ] 모든 파일이 **내 폴더** 안에 있는가
- [ ] 파일명이 `{문제번호}_{문제이름}` 규칙에 맞는가
- [ ] 문제 URL, 시간/공간복잡도 주석이 있는가
- [ ] `__pycache__`, `.vscode` 같은 불필요한 파일이 없는가
- [ ] PR 제목과 설명이 명확한가

## 🚫 하지 말아야 할 것

- ❌ 다른 사람의 코드를 그대로 복사
- ❌ 온라인 모범 답안을 이해 없이 붙여넣기
- ❌ PR 없이 원본 `main`에 직접 push
- ❌ 다른 사람 폴더에 파일 추가/수정
- ⚠️ 한 주 분량을 커밋 하나에 몰아넣기 (문제 단위로 나누세요)

## 🛠️ 유용한 커맨드

```bash
# upstream 최신화
git fetch upstream && git merge upstream/main

# 마지막 커밋 취소 (파일은 유지)
git reset --soft HEAD~1

# 커밋 메시지 수정
git commit --amend

# 브랜치 삭제
git branch -d week01/오명헌              # 로컬
git push origin --delete week01/오명헌   # 원격
```

## ❓ FAQ

**Q. 문제를 못 풀었어요. PR을 제출해도 되나요?**
네, 꼭 제출하세요. 어디서 막혔는지 PR 설명에 적어주시면 리뷰에서 함께 풉니다. 미제출보다 미완성이 훨씬 낫습니다.

**Q. 다른 언어로 풀어도 되나요?**
Python, Java, C++, JavaScript 등 자유입니다. 다만 한 주 안에서는 한 언어로 통일하는 게 리뷰에 좋습니다.

**Q. 같은 문제를 여러 방법으로 풀었어요.**
`42576_완주하지_못한_선수_v2.py` 처럼 접미사를 붙이고, 주석에 두 방식의 복잡도 차이를 적어주세요.

**Q. 이전 주차 문제를 나중에 풀어도 되나요?**
됩니다. 해당 주차 폴더에 추가하고, 현재 주차 PR에 함께 올려주세요. 문제 수가 적은 주차(3·4·9·10주)가 보충하기 좋습니다.

**Q. 문제 수가 주차마다 다른데요?**
Kit 유형별 문제 수가 실제로 다릅니다 (2~7문제, 총 47문제). 자세한 분포는 [README](./README.md#-주간-일정)를 참고하세요.
