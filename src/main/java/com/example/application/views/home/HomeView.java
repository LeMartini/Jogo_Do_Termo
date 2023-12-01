package com.example.application.views.home;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Home")
@Route(value = "Home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class HomeView extends Composite<VerticalLayout> {

    public HomeView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        Image image = new Image("jogo-do-termo (2)\\jogo-do-termo\\src\\main\\resources\\META-INF\\resources\\icons\\ImageLogo.png", "Logo Jogo");
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        Button buttonPrimary = new Button("Jogar", event -> getUI().ifPresent(ui -> ui.navigate("/Jogo")));
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        Button buttonPrimary2 = new Button("Sobre Nós", event -> getUI().ifPresent(ui -> ui.navigate("/Sobre-Nos")));
        getContent().addClassName(Padding.XSMALL);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutRow2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutColumn2.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, image);
        image.setWidth("700px");
        image.setHeight("200px");
        layoutRow3.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.setHeight("200px");
        layoutRow3.setAlignItems(Alignment.START);
        layoutRow3.setJustifyContentMode(JustifyContentMode.CENTER);
        buttonPrimary.setText("Jogar!");
        buttonPrimary.setWidth("500px");
        buttonPrimary.setHeight("150px");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutRow4.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.setHeight("200px");
        layoutRow4.setAlignItems(Alignment.START);
        layoutRow4.setJustifyContentMode(JustifyContentMode.CENTER);
        buttonPrimary2.setText("Sobre Nós");
        buttonPrimary2.setWidth("500px");
        buttonPrimary2.setHeight("150px");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(layoutColumn2);
        layoutColumn2.add(layoutColumn3);
        layoutColumn3.add(image);
        layoutColumn3.add(layoutRow3);
        layoutRow3.add(buttonPrimary);
        layoutColumn3.add(layoutRow4);
        layoutRow4.add(buttonPrimary2);
    }
}
