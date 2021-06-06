# IntelliJ Translator
### Simple IntelliJ IDEA plugin for translate
<p float="left">
<img alt="Qries" src="https://img.shields.io/github/workflow/status/timurbabs/IntelliJ-Translator/Java%20CI%20with%20Gradle?style=flat-square">
<img alt="Qries" src="https://img.shields.io/github/v/release/timurbabs/IntelliJ-Translator?style=flat-square">
<img alt="Qries" src="https://img.shields.io/github/repo-size/timurbabs/IntelliJ-Translator?style=flat-square">
</p>

## Features
- The ability to both **replace** and simply **display** the translation of the text, taking into account **all special characters**.;
- The quality of the translation is comparable to that of **google translator**, because we use its **API** :)


## Installation
<a name="instruction"></a>
### Installation from disk﻿
**1.** Download the **ZIP** file with the latest version of **IntelliJ Plugin** from [releases](https://github.com/timurbabs/IntelliJ-Translator/rele.. "releases").    
**2.** Press **Ctrl+Alt+S** to open IDE settings and select **Plugins**.    
**3.** On the **Plugins** page, click :fa-cog: and then click **Install Plugin from Disk**.    
**4.** Select the plugin archive file and click **OK**.
### Installation from source﻿
**1.** Clone this repository.

`git clone https://github.com/timurbabs/IntelliJ-Translator.git`

**2.** In the cloned repository, run:

`~$ ./gradlew` for **Linux**
`> gradlew` for **Windows**

**3.** **ZIP** file with the plugin will appear in the **build/distributions** folder.    
**4.** Follow [this](#instruction) instruction from **point 2**.

## Usage
### Replacing text

To translate text with replacement, press **Ctrl+\ , Ctrl+T** and select languages ​​for translation.

<img alt="Qries" src="https://sun9-9.userapi.com/impg/1xe7iskxjbplfrwG4Hc7ZxRItj1KC3IAU6KYNA/CJEE9SD6Lkk.jpg?size=407x135&quality=96&sign=4c529acda3237d3e4da4fee09c205330&type=album">

<img alt="Qries" src="https://sun9-28.userapi.com/impg/YIsrnC7b-GWDa6T0ojttj8LGNi23jJMpjBnjSA/SIgau3hve1w.jpg?size=173x69&quality=96&sign=dfe900630b91b9d9626eef4766772e9a&type=album">

<img alt="Qries" src="https://sun9-20.userapi.com/impg/OiQQ0Su4k95HmfAs9xIWAl-uTBt2IY_sT3c5Cg/aun01jM3hl8.jpg?size=173x72&quality=96&sign=01555b24b4d03c4ef60dfcefca2554c1&type=album">

You can also translate text with replacement **without choosing languages**. For this **select default languages ​​in the plugin settings** (**File -> Settings -> Tools -> Translator**) or by pressing **Ctrl+\ , Ctrl+S** , and then you do not have to select languages ​​for translation. 
For replacing without choosing languages press **Ctrl+\ , Ctrl+P**.

If you do not know the language from which you are going to translate, you can use the **automatic language detection**. For this press **Ctrl+\ , Ctrl+[**. Тhe default language will be used as the language to translate into.

### Display text

If you **do not need to replace the text**, but you just want to find out its translation, then you can **display** it on the screen by pressing **Сtrl+\, Ctrl+R**, to choose language from menu.

[![](https://sun9-51.userapi.com/impg/JyO40X09FA_JhQk9dXWHzeS3pKNFAklEKNUQjA/PecfT-8k81w.jpg?size=177x94&quality=96&sign=5fd9d0bb58afcd4a4959619e464adcee&type=album)](https://sun9-51.userapi.com/impg/JyO40X09FA_JhQk9dXWHzeS3pKNFAklEKNUQjA/PecfT-8k81w.jpg?size=177x94&quality=96&sign=5fd9d0bb58afcd4a4959619e464adcee&type=album)


If you do not want to choose a language or do not know the word in which language in front of you, then you can use the option of **displaying without choosing** a language (**Ctrl+\, Ctrl+Q**) or the ability to **automatically detect** the language (**Ctrl+\ , Ctrl+]**).


------------


### You can access all previous hotkeys by pressing **right-click** and select IntelliJ Translator menu.

[![](https://sun9-32.userapi.com/impg/Sq6qQ4_lbuPlbjBsmzU3kMZiL6XE69u5teVQtA/CX9lqO6-X0s.jpg?size=767x480&quality=96&sign=2f4538ee6d515ce8ebc9e751e63d26c1&type=album)](https://sun9-32.userapi.com/impg/Sq6qQ4_lbuPlbjBsmzU3kMZiL6XE69u5teVQtA/CX9lqO6-X0s.jpg?size=767x480&quality=96&sign=2f4538ee6d515ce8ebc9e751e63d26c1&type=album)

------------

### You can change hotkeys in File -> Settings -> Keymap -> Plugins -> Translator.

------------


### IntelliJ Translator can translate only selected text!
