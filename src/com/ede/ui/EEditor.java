package com.ede.ui;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.autocomplete.ShorthandCompletion;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rsyntaxtextarea.templates.CodeTemplate;
import org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate;

public class EEditor extends JPanel {

   private static final long serialVersionUID = 1L;
   RSyntaxTextArea textArea;
   public EEditor() {

      //JPanel cp = new JPanel(new BorderLayout());
      setLayout(new BorderLayout());
       textArea = new RSyntaxTextArea(20, 60);

      textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
      textArea.setCodeFoldingEnabled(true);
      textArea.setAntiAliasingEnabled(true);
      RTextScrollPane sp = new RTextScrollPane(textArea);
      sp.setFoldIndicatorEnabled(true);
      add(sp);
      
      // Whether templates are enabled is a global property affecting all
      // RSyntaxTextAreas, so this method is static.
      RSyntaxTextArea.setTemplatesEnabled(true);

      // Code templates are shared among all RSyntaxTextAreas. You add and
      // remove templates through the shared CodetemplateManager instance.
      CodeTemplateManager ctm = RSyntaxTextArea.getCodeTemplateManager();
      
      // StaticCodetemplates are templates that insert static text before and
      // after the current caret position. This template is basically shorthand
      // for "System.out.println(".
      CodeTemplate ct = new StaticCodeTemplate("sout", "System.out.println(",
            null);
      ctm.addTemplate(ct);
       CompletionProvider provider = createCompletionProvider();
       AutoCompletion ac = new AutoCompletion(provider);
      ac.install(textArea);
      // This template is for a for-loop. The caret is placed at the upper
      // bound of the loop.
      ct = new StaticCodeTemplate("for", "for (int i=0; i<", "; i++) {\n\t\n}\n");
      ctm.addTemplate(ct);
       InputStream in = getClass().getResourceAsStream( "dark.xml");
			try {
				Theme theme = Theme.load(in);
				theme.apply(textArea);
			} catch (Exception ioe) {
				ioe.printStackTrace();}


   }
   
    private CompletionProvider createCompletionProvider() {

      // A DefaultCompletionProvider is the simplest concrete implementation
      // of CompletionProvider. This provider has no understanding of
      // language semantics. It simply checks the text entered up to the
      // caret position for a match against known completions. This is all
      // that is needed in the majority of cases.
      DefaultCompletionProvider provider = new DefaultCompletionProvider();

      // Add completions for all Java keywords. A BasicCompletion is just
      // a straightforward word completion.
      provider.addCompletion(new BasicCompletion(provider, "abstract"));
      provider.addCompletion(new BasicCompletion(provider, "assert"));
      provider.addCompletion(new BasicCompletion(provider, "break"));
      provider.addCompletion(new BasicCompletion(provider, "case"));
      provider.addCompletion(new BasicCompletion(provider, "catch"));
      provider.addCompletion(new BasicCompletion(provider, "class"));
      provider.addCompletion(new BasicCompletion(provider, "const"));
      provider.addCompletion(new BasicCompletion(provider, "continue"));
      provider.addCompletion(new BasicCompletion(provider, "default"));
      provider.addCompletion(new BasicCompletion(provider, "do"));
      provider.addCompletion(new BasicCompletion(provider, "else"));
      provider.addCompletion(new BasicCompletion(provider, "enum"));
      provider.addCompletion(new BasicCompletion(provider, "extends"));
      provider.addCompletion(new BasicCompletion(provider, "final"));
      provider.addCompletion(new BasicCompletion(provider, "finally"));
      provider.addCompletion(new BasicCompletion(provider, "for"));
      provider.addCompletion(new BasicCompletion(provider, "goto"));
      provider.addCompletion(new BasicCompletion(provider, "if"));
      provider.addCompletion(new BasicCompletion(provider, "implements"));
      provider.addCompletion(new BasicCompletion(provider, "import"));
      provider.addCompletion(new BasicCompletion(provider, "instanceof"));
      provider.addCompletion(new BasicCompletion(provider, "interface"));
      provider.addCompletion(new BasicCompletion(provider, "native"));
      provider.addCompletion(new BasicCompletion(provider, "new"));
      provider.addCompletion(new BasicCompletion(provider, "package"));
      provider.addCompletion(new BasicCompletion(provider, "private"));
      provider.addCompletion(new BasicCompletion(provider, "protected"));
      provider.addCompletion(new BasicCompletion(provider, "public"));
      provider.addCompletion(new BasicCompletion(provider, "return"));
      provider.addCompletion(new BasicCompletion(provider, "static"));
      provider.addCompletion(new BasicCompletion(provider, "strictfp"));
      provider.addCompletion(new BasicCompletion(provider, "super"));
      provider.addCompletion(new BasicCompletion(provider, "switch"));
      provider.addCompletion(new BasicCompletion(provider, "synchronized"));
      provider.addCompletion(new BasicCompletion(provider, "this"));
      provider.addCompletion(new BasicCompletion(provider, "throw"));
      provider.addCompletion(new BasicCompletion(provider, "throws"));
      provider.addCompletion(new BasicCompletion(provider, "transient"));
      provider.addCompletion(new BasicCompletion(provider, "try"));
      provider.addCompletion(new BasicCompletion(provider, "void"));
      provider.addCompletion(new BasicCompletion(provider, "volatile"));
      provider.addCompletion(new BasicCompletion(provider, "while"));

      // Add a couple of "shorthand" completions. These completions don't
      // require the input text to be the same thing as the replacement text.
      provider.addCompletion(new ShorthandCompletion(provider, "sysout",
            "System.out.println(", "System.out.println("));
      provider.addCompletion(new ShorthandCompletion(provider, "syserr",
            "System.err.println(", "System.err.println("));

      return provider;

   }

   public String getText()
   {
      return textArea.getText();
   }
}