function solution(scores) {
  const answer = '';
  return answer;
}

describe('상호 평가', () => {
  const scores = [
    [100, 90, 98, 88, 65],
    [50, 45, 99, 85, 77],
    [47, 88, 95, 80, 67],
    [61, 57, 100, 80, 65],
    [24, 90, 94, 75, 65],
  ];

  it('should be return null', () => {
    expect(solution(scores)).toBe('FBABD');
  });
});
