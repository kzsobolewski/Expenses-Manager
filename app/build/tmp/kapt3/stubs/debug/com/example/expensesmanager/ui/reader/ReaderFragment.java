package com.example.expensesmanager.ui.reader;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010$\u001a\u00020\u0012H\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\'H\u0002J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/example/expensesmanager/ui/reader/ReaderFragment;", "Landroidx/fragment/app/Fragment;", "()V", "REQUEST_IMAGE_CAPTURE", "", "currentPhotoPath", "", "getCurrentPhotoPath", "()Ljava/lang/String;", "setCurrentPhotoPath", "(Ljava/lang/String;)V", "viewModel", "Lcom/example/expensesmanager/ui/reader/ReaderViewModel;", "checkForCameraPermission", "", "createImageFile", "Ljava/io/File;", "firebaseTextRecognition", "", "bitmap", "Landroid/graphics/Bitmap;", "makePermissionsRequest", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "openCamera", "processRecognizedText", "fbVisionText", "Lcom/google/firebase/ml/vision/text/FirebaseVisionText;", "rotateImage", "source", "angle", "", "app_debug"})
public final class ReaderFragment extends androidx.fragment.app.Fragment {
    private com.example.expensesmanager.ui.reader.ReaderViewModel viewModel;
    private final int REQUEST_IMAGE_CAPTURE = 1;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentPhotoPath;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final android.graphics.Bitmap rotateImage(android.graphics.Bitmap source, float angle) {
        return null;
    }
    
    private final void firebaseTextRecognition(android.graphics.Bitmap bitmap) {
    }
    
    private final void processRecognizedText(com.google.firebase.ml.vision.text.FirebaseVisionText fbVisionText) {
    }
    
    private final boolean checkForCameraPermission() {
        return false;
    }
    
    private final void openCamera() {
    }
    
    private final void makePermissionsRequest() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentPhotoPath() {
        return null;
    }
    
    public final void setCurrentPhotoPath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final java.io.File createImageFile() throws java.io.IOException {
        return null;
    }
    
    public ReaderFragment() {
        super();
    }
}