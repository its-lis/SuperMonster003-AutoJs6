package org.autojs.autojs.model.explorer;

import androidx.annotation.NonNull;

import com.stardust.app.GlobalAppContext;
import com.stardust.pio.PFile;
import com.stardust.util.Objects;

import org.autojs.autojs.model.script.ScriptFile;
import org.autojs.autojs6.R;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ExplorerFileItem implements ExplorerItem {

    private static final Set<String> sEditableFileExts = new HashSet<>(Arrays.asList(
            "js", "java", "xml", "json", "txt", "log", "ts"
    ));

    private final PFile mFile;
    private final ExplorerPage mParent;

    public ExplorerFileItem(PFile file, ExplorerPage parent) {
        if (file == null) {
            throw new NullPointerException(GlobalAppContext
                    .getString(R.string.error_method_called_with_null_argument,
                            "ExplorerFileItem.constructor", "file"));
        }
        mFile = file;
        mParent = parent;
    }

    public ExplorerFileItem(String path, ExplorerPage parent) {
        mFile = new PFile(path);
        mParent = parent;
    }

    public ExplorerFileItem(File file, ExplorerPage parent) {
        mFile = new PFile(file.getPath());
        mParent = parent;
    }

    public PFile getFile() {
        return mFile;
    }

    @Override
    public String getName() {
        return mFile.getName();
    }

    @Override
    public ExplorerPage getParent() {
        return mParent;
    }

    @Override
    public String getPath() {
        return mFile.getPath();
    }

    @Override
    public long lastModified() {
        return mFile.lastModified();
    }

    @Override
    public boolean canDelete() {
        return mFile.canWrite();
    }

    @Override
    public boolean canRename() {
        return mFile.canWrite();
    }

    public ExplorerFileItem rename(String newName) {
        return new ExplorerFileItem(mFile.renameTo(newName), getParent());
    }

    @Override
    public String getType() {
        if (mFile.isDirectory()) {
            return "/";
        }
        return mFile.getExtension();
    }

    @Override
    public long getSize() {
        return mFile.length();
    }

    @Override
    public ScriptFile toScriptFile() {
        return new ScriptFile(mFile);
    }

    @Override
    public boolean isEditable() {
        return sEditableFileExts.contains(getType());
    }

    @Override
    public boolean isExecutable() {
        String type = getType();
        return type.equals("js") || type.equals("auto");
    }

    @NonNull
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "mFile=" + mFile + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExplorerFileItem that = (ExplorerFileItem) o;
        return Objects.equals(mFile, that.mFile);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mFile);
    }
}

