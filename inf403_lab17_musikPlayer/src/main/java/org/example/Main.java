package org.example;


public class Main {
    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        playlist.clear();
        playlist.load();
        playlist.add(new Track( "Ночь", "Mayot", "C:\\Users\\dasts\\Desktop\\Itis\\lol\\inf403_sem2\\inf403_lab17_musikPlayer\\MusicPlaylist\\MAYOT_-_noch_76470274.wav" ));
        playlist.add(new Track("Не надо", "Mayot", "C:\\Users\\dasts\\Desktop\\Itis\\lol\\inf403_sem2\\inf403_lab17_musikPlayer\\MusicPlaylist\\MAYOT_-_ne_nado_76470288.wav"));
        playlist.add(new Track("Ненавижу", "Mayot", "C:\\Users\\dasts\\Desktop\\Itis\\lol\\inf403_sem2\\inf403_lab17_musikPlayer\\MusicPlaylist\\MAYOT_-_nenavizhu_76470287.wav"));
        playlist.add(new Track("Прощай", "Mayot", "C:\\Users\\dasts\\Desktop\\Itis\\lol\\inf403_sem2\\inf403_lab17_musikPlayer\\MusicPlaylist\\MAYOT_-_proshhajj_76470291.wav"));
        playlist.add(new Track("Сможем ли мы", "Mayot", "C:\\Users\\dasts\\Desktop\\Itis\\lol\\inf403_sem2\\inf403_lab17_musikPlayer\\MusicPlaylist\\MAYOT_-_smozhem_li_my_76470281.wav"));
        playlist.add(new Track("9 AM in Calabasas", "Playboy Carti", "C:\\Users\\dasts\\Desktop\\Itis\\lol\\inf403_sem2\\inf403_lab17_musikPlayer\\MusicPlaylist\\Playboi_Carti_-_9_AM_in_Calabasas_72187789.wav"));
        //playlist.add(new Track("Проверка", "проверка", "C:\\Users\\dasts\\Desktop\\Itis\\lol\\inf403_sem2\\inf403_lab17_musikPlayer\\MusicPlaylist\\reklamnyiy-dizayn-tehnologii-smyisla-obratnogo-otscheta-audio-42553.wav"));
        playlist.add(new Track("Царица", "Анна Асти", "C:\\Users\\dasts\\Desktop\\Itis\\lol\\inf403_sem2\\inf403_lab17_musikPlayer\\MusicPlaylist\\ANNA_ASTI_-_Carica_76368874.wav"));

        playlist.save();

        Console console = new Console();
        console.startCommand();
    }
}