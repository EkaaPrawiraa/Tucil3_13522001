# Tugas Kecil 3 Strategi Algoritma

Membuat program word ladder dengan algoritma UCS, GBFS, dan A*

## WordLadder Game
 Word ladder (juga dikenal sebagai Doublets, word-links, change-the-word puzzles,
 paragrams, laddergrams, atau word golf) adalah salah satu permainan kata yang terkenal
 bagi seluruh kalangan. Word ladder ditemukan oleh Lewis Carroll, seorang penulis dan
 matematikawan, pada tahun 1877. Pada permainan ini, pemain diberikan dua kata yang
 disebut sebagai start word dan end word. Untuk memenangkan permainan, pemain harus
 menemukan rantai kata yang dapat menghubungkan antara start word dan end word.
 Banyaknya huruf pada start word dan end word selalu sama. Tiap kata yang berdekatan
 dalam rantai kata tersebut hanya boleh berbeda satu huruf saja. Pada permainan ini,
 diharapkan solusi optimal, yaitu solusi yang meminimalkan banyaknya kata yang dimasukkan
 pada rantai kata.

## What is UCS, GBFS, and A*

UCS (Uniform Cost Search): Algoritma ini mencari solusi dengan biaya terendah. Ia mengeksplorasi simpul berdasarkan biaya jalur dari simpul awal ke simpul yang sedang dipertimbangkan.
GBFS (Greedy Best-First Search): Algoritma ini memprioritaskan simpul berdasarkan nilai heuristik. Ia cenderung memilih simpul yang dianggap paling dekat dengan tujuan, tanpa mempertimbangkan biaya jalur yang sebenarnya.
A (A-Star)**: Algoritma ini adalah perpaduan antara UCS dan GBFS. Ia menggunakan fungsi heuristik untuk menghitung perkiraan biaya total dari simpul awal ke tujuan melalui simpul yang sedang dipertimbangkan. A berusaha menemukan jalur dengan biaya terkecil yang mungkin, dengan mempertimbangkan baik biaya aktual maupun estimasi biaya ke depan (heuristik).

## Prerequisite

1. Install Java

## Cara Menjalakan dan Menggunakan

1. Jalankan program pada terminal
    ```bash
   java -cp bin Main
   ```
2. Input command kata awal dan kata tujuan
3. Input algoritma yang diinginkan (bisa menggunakan nama atau angka yang ada)
4. Bisa melakukan input berulang kali dengan menjawab pertanyaan "Do you wish to stop?(y/n)" dengan input "y" atau "Y" atau "stop"


## Informasi Pribadi

| 13522001 | Mohammad Nugraha Eka Prawira       |

