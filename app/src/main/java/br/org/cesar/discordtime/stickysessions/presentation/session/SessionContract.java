package br.org.cesar.discordtime.stickysessions.presentation.session;

import java.util.List;

import br.org.cesar.discordtime.stickysessions.domain.model.Note;

public interface SessionContract {

    interface Presenter {
        void attachView(SessionContract.View view);
        void detachView();
        void onShareSession();
        void onAddNoteClicked();
        void addNewNote(String sessionId, String description);
        void onNoteWidgetClicked(Note note);
        void onResume();
        void currentSession(String sessionId);
        void removeNote(Note note);
    }

    interface View {
        void addNoteToNoteList(Note note);
        void shareSession(String sessionId);
        void cleanNotes();
        void removeNote(Note note);
        void startLoadingNote();
        void stopLoadingNote();
        void startLoadingAllNotes();
        void stopLoadingAllNotes();
        void displayAddNoteDialog(List<String> topics);
        void displaySession();
        void displayError(String message);
        void displayNotes(List<Note> notes);
        void displayErrorInvalidNotes();
        void displayNoteContent(Note note);
    }
}
