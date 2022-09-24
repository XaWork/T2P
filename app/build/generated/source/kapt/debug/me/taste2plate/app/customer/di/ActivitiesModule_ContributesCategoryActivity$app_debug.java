package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.product.CategoryActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesCategoryActivity$app_debug.CategoryActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesCategoryActivity$app_debug {
  private ActivitiesModule_ContributesCategoryActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(CategoryActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CategoryActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface CategoryActivitySubcomponent extends AndroidInjector<CategoryActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<CategoryActivity> {}
  }
}
