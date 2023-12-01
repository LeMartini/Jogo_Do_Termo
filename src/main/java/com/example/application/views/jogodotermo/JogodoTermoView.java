package com.example.application.views.jogodotermo;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;

@PageTitle("Jogo do Termo")
@Route(value = "Jogo", layout = MainLayout.class)
@Uses(Icon.class)
public class JogodoTermoView extends Composite<VerticalLayout> {
    private String word = "bunny";
    private Div results;
    private int tentativas = 0;

    public JogodoTermoView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn6 = new VerticalLayout();
        Avatar avatar = new Avatar();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        H3 h3 = new H3();
        Paragraph textMedium = new Paragraph();
        Paragraph textMedium2 = new Paragraph();


        VerticalLayout layoutColumn7 = new VerticalLayout();
        getContent().addClassName(Padding.XSMALL);
        getContent().setWidth("100%");
        getContent().setHeight("580px");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.addClassName(Padding.SMALL);
        layoutColumn2.setWidth("100%");
        layoutColumn2.setHeight("580px");
        layoutRow2.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutColumn6.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.setWidth("100%");
        layoutColumn6.getStyle().set("flex-grow", "1");
        avatar.setName("Firstname Lastname");
        avatar.setWidth("150px");
        avatar.setHeight("550px");
        layoutColumn3.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth("450px");
        layoutColumn3.setHeight("550px");
        layoutColumn4.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.addClassName(Padding.XSMALL);
        layoutColumn4.setWidth("350px");
        layoutColumn4.setHeight("550px");
        h3.setText("Como Jogar:");
        h3.setWidth("max-content");
        textMedium.setText(
                "Ficamos felizes em saber que você está interessado em jogar o Termo! Vamos te ensinar a jogar:");
        textMedium.setWidth("100%");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        textMedium2.setText(
                "O principal objetivo do jogo é descobrir qual a palavra sorteada. Um detalhe muito importante é que a palavra possui única e exclusivamente 5 letras! Para isso, você possui 6 tentativas, e em cada uma vamos te sinalizar se alguma das letras existe na palavra secreta e se a posição está correta! Fácil, né?Uma dica: Como a palavra sorteada tem apenas 5 letras, coloque apenas essa quantidade nas suas tentativas. Bom jogo!");
        textMedium2.setWidth("100%");
        textMedium2.getStyle().set("font-size", "var(--lumo-font-size-m)");
        layoutColumn7.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn7);
        layoutColumn7.setWidth("100%");
        layoutColumn7.getStyle().set("flex-grow", "1");
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(layoutRow2);
        layoutRow2.add(layoutColumn6);
        layoutRow2.add(avatar);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(layoutColumn4);
        layoutColumn4.add(h3);
        layoutColumn4.add(textMedium);
        layoutColumn4.add(textMedium2);

        layoutRow2.add(layoutColumn7);

        adicionarElementos();
    }

    private void adicionarElementos() {
        if (tentativas < 5) {
            // Place for user to input their guess
            results = new Div();
            getContent().add(results);

            // Horizontal layout to contain the text, TextField, and button
            HorizontalLayout inputButtonLayout = new HorizontalLayout();
            inputButtonLayout.addClassName(Gap.XSMALL);
            inputButtonLayout.addClassName(Padding.XSMALL);
            inputButtonLayout.setHeightFull();
            getContent().add(inputButtonLayout);

            // Text
            H3 h32 = new H3("Vamos Jogar!");
            h32.setWidth("max-content");
            inputButtonLayout.add(h32);

            // TextField for user input
            TextField guessInput = new TextField();
            guessInput.setLabel("Faça sua tentativa");
            inputButtonLayout.add(guessInput);

            // Button to check guess
            Button buttonPrimary = new Button("Checar tentativa");
            buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            buttonPrimary.setWidth("170px");
            buttonPrimary.setHeight("30px");
            buttonPrimary.addClickListener(buttonClickEvent -> checarTentativa(guessInput.getValue()));
            inputButtonLayout.add(buttonPrimary);

            tentativas++;
        } else {
            Notification.show("Tentativas esgotadas");
        }
    }

    private void checarTentativa(String guess) {
        Div div = new Div();

        for (int i = 0; i < guess.length(); i++) {
            String letter = guess.substring(i, i + 1);
            Span badge = new Span(letter);
            if (letter.equals(word.substring(i, i + 1))) {
                badge.getElement().getThemeList().add("badge success primary");
            } else if (word.indexOf(letter) > -1) {
                badge.getElement().getThemeList().add("badge primary");
            } else {
                badge.getElement().getThemeList().add("badge contrat");
            }
            div.add(badge);
        }
        results.add(div);

        // Adiciona novos elementos se ainda houver tentativas restantes
        if (tentativas < 6) {
            adicionarElementos();
        } else {
            exibirMensagemTentativasEsgotadas();
        }

        // Verifica se o palpite é correto
        if (guess.equals(word)) {
            exibirMensagemAcerto();
        }
    }

    private void exibirMensagemTentativasEsgotadas() {
        Dialog dialog = new Dialog();
        dialog.add(new Text("Tentativas esgotadas!"));
        Button voltarInicioButton = new Button("Voltar para o Início", event -> getUI().ifPresent(ui -> ui.navigate("")));
        Button tentarNovamenteButton = new Button("Tentar Novamente", event -> getUI().ifPresent(ui -> ui.getPage().reload()));
        dialog.add(voltarInicioButton, tentarNovamenteButton);
        dialog.open();
    }

    private void exibirMensagemAcerto() {
        Dialog dialog = new Dialog();
        dialog.add(new Text("Parabéns! Você acertou a palavra."));
        Button voltarInicioButton = new Button("Voltar para o Início", event -> getUI().ifPresent(ui -> ui.navigate("")));
        Button tentarNovamenteButton = new Button("Tentar Novamente", event -> getUI().ifPresent(ui -> ui.getPage().reload()));
        dialog.add(voltarInicioButton, tentarNovamenteButton);
        dialog.open();
    }
}