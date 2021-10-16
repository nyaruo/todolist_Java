# 概要(Overview)
 このアプリは、Swingを用いたタスク管理アプリである。
 注 ) timer.wavファイルはファイルサイズが大きくgitへアップロード不可であったため、削除した

JDKをインストール後、以下のコマンドで実行が可能

```
$ javac Sample.java
$ java Sample
```

# 説明(Description)
使用したコンポーネントは、JLabel, JButton, JPanel, JTabbedPaneとなる。

- doSetActionListener >> ボタンが押された場合の，イベント処理を行った．
	新規作成ボタンを押した際にタスク入力画面を表示.  
	また，タスク入力後，OKボタンが押されると，TODOタブの方に追加される．
- todoActionListener >> ボタンが押された場合の，イベント処理を行った．
	タスクがセットされたボタンを押したら，メッセージダイアログを表示．
	「このタスクは終了しましたか？」で，DONEを押すと，選択したタスクがDONEタブに移動．
	また，削除を押すと，選択したタスクが削除される．
- doneActionListener >> ボタンが押された場合の，イベント処理を行った．
	「このタスクは削除しますか？」で，削除を押すと，選択したタスクが削除される．
~~- timerActionListener >> ボタンが押された場合の，イベント処理を行った． 注) ファイルサイズが大きかったため、削除
	10分タイマーボタンが押された場合，Mainでセットしたtimer.wavを再生する．
	10分経つと，お知らせの通知音が鳴る．~~
- helpActionListener >> ボタンが押された場合の，イベント処理を行った．
	helpボタンが押されたとき，画像を表示．
 ~~2. timer.wav
	timerActionListenerで再生される音声ファイル．~~

 3. help.png
	helpActionListenerで表示される画像ファイル．

# 操作方法(Operation Method)
	Clicking the "New" button allows you to enter a new task.
	The entered task will be added to the TODO list.
	When you select a task in the TODO list, you can select DONE for tasks that have been completed, or DELETE for tasks that you want to delete.
	If you select DONE, the task will be moved to the DONE tab. Clicking "Delete" will delete the selected task.
	In the DONE tab, you can also delete tasks that are no longer needed by selecting them.
	Clicking the 10-minute timer button will play a music file to remind you of the 10-minute mark.
	Clicking the Help button will display an image file with instructions on how to use the program.
	
# イメージ画像(Image)

![aa](https://user-images.githubusercontent.com/68112807/137584195-5416ddfc-909c-41f4-976a-71eeda0f49e7.gif)
