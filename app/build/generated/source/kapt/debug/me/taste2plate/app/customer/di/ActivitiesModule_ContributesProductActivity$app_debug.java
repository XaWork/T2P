package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.product.ProductActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesProductActivity$app_debug.ProductActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesProductActivity$app_debug {
  private ActivitiesModule_ContributesProductActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ProductActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ProductActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ProductActivitySubcomponent extends AndroidInjector<ProductActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ProductActivity> {}
  }
}
