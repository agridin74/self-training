import { Article } from './article.model';

describe('Article', () => {
  it('should create an instance', () => {
    expect(new Article('1','2',0)).toBeTruthy();
  });
});
