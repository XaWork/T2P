package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.product.ProductSearchActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesProductSearchActivity$app_debug.ProductSearchActivitySubcomponent
          .class
)
public abstract class ActivitiesModule_ContributesProductSearchActivity$app_debug {
  private ActivitiesModule_ContributesProductSearchActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ProductSearchActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ProductSearchActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ProductSearchActivitySubcomponent
      extends AndroidInjector<ProductSearchActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ProductSearchActivity> {}
  }
}
