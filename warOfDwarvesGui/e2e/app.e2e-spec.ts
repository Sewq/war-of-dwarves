import { WarOfDwarvesGuiPage } from './app.po';

describe('war-of-dwarves-gui App', function() {
  let page: WarOfDwarvesGuiPage;

  beforeEach(() => {
    page = new WarOfDwarvesGuiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
