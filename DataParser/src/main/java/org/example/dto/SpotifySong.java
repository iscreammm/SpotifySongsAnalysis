package org.example.dto;

import java.sql.Timestamp;

public class SpotifySong {
    private String trackId;
    private String trackName;
    private String trackArtist;
    private double trackPopularity;
    private String trackAlbumId;
    private String trackAlbumName;
    private Timestamp trackAlbumReleaseDate;
    private String playlistName;
    private String playlistId;
    private String playlistGenre;
    private String playlistSubgenre;
    private double danceability;
    private double energy;
    private double key;
    private double loudness;
    private double mode;
    private double speechiness;
    private double acousticness;
    private double instrumentalness;
    private double liveness;
    private double valence;
    private double tempo;
    private double durationMs;

    public SpotifySong(String trackId, String trackName, String trackArtist, double trackPopularity,
                       String trackAlbumId, String trackAlbumName, Timestamp trackAlbumReleaseDate, String playlistName,
                       String playlistId, String playlistGenre, String playlistSubgenre, double danceability,
                       double energy, double key, double loudness, double mode, double speechiness, double acousticness,
                       double instrumentalness, double liveness, double valence, double tempo, double durationMs) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackArtist = trackArtist;
        this.trackPopularity = trackPopularity;
        this.trackAlbumId = trackAlbumId;
        this.trackAlbumName = trackAlbumName;
        this.trackAlbumReleaseDate = trackAlbumReleaseDate;
        this.playlistName = playlistName;
        this.playlistId = playlistId;
        this.playlistGenre = playlistGenre;
        this.playlistSubgenre = playlistSubgenre;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.durationMs = durationMs;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(String trackArtist) {
        this.trackArtist = trackArtist;
    }

    public double getTrackPopularity() {
        return trackPopularity;
    }

    public void setTrackPopularity(double trackPopularity) {
        this.trackPopularity = trackPopularity;
    }

    public String getTrackAlbumId() {
        return trackAlbumId;
    }

    public void setTrackAlbumId(String trackAlbumId) {
        this.trackAlbumId = trackAlbumId;
    }

    public String getTrackAlbumName() {
        return trackAlbumName;
    }

    public void setTrackAlbumName(String trackAlbumName) {
        this.trackAlbumName = trackAlbumName;
    }

    public Timestamp getTrackAlbumReleaseDate() {
        return trackAlbumReleaseDate;
    }

    public void setTrackAlbumReleaseDate(Timestamp trackAlbumReleaseDate) {
        this.trackAlbumReleaseDate = trackAlbumReleaseDate;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistGenre() {
        return playlistGenre;
    }

    public void setPlaylistGenre(String playlistGenre) {
        this.playlistGenre = playlistGenre;
    }

    public String getPlaylistSubgenre() {
        return playlistSubgenre;
    }

    public void setPlaylistSubgenre(String playlistSubgenre) {
        this.playlistSubgenre = playlistSubgenre;
    }

    public double getDanceability() {
        return danceability;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getKey() {
        return key;
    }

    public void setKey(double key) {
        this.key = key;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public double getMode() {
        return mode;
    }

    public void setMode(double mode) {
        this.mode = mode;
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public double getLiveness() {
        return liveness;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public double getValence() {
        return valence;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(double durationMs) {
        this.durationMs = durationMs;
    }
}
