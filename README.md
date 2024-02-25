# menU
KITの学生食堂「オルタス」の献立を組み立てるAndroidアプリです．  
"you"の略語として使用される"u"を敢えて大文字にすることで，

> "あなた"にとっての理想の献立を見つけて欲しい．

というコンセプトを強調したつもりです．

## 仕様
- 料理は主食・おかず (主菜)・小鉢 (副菜)・デザートの4つのカテゴリーに分類されており，オーバーフローメニューから切り替えることができます．
- それぞれの料理に対して料金・カロリー・赤緑黄の点数が表示されます．
- 操作方法
  - 表示された料理をタップすることで，献立に料理を追加していきます．
  - 料理の追加に伴って上記3つの属性の合計が変化します．
  - 追加した料理を長押しすると削除の確認ダイアログが表示されます．

## ディレクトリ構成
- `res/layout`ディレクトリ内の`.xml`ファイルに画面構成を記述
- `java`ディレクトリ内の`.java`ファイルに処理を記述
- `res/values`ディレクトリ内の`strings.xml`ファイルに表示文字列を記述
  - アプリを多言語に対応させたい場合，別言語で記述された`strings.xml`を所定のフォルダに入れておくと，言語設定に従ってOSが自動的に`strings.xml`を切り替えてくれます．