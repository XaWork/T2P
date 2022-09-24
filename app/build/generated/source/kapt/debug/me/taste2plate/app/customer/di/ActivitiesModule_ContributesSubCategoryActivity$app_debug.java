package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.product.SubCategoryActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesSubCategoryActivity$app_debug.SubCategoryActivitySubcomponent
          .class
)
public abstract class ActivitiesModule_ContributesSubCategoryActivity$app_debug {
  private ActivitiesModule_ContributesSubCategoryActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(SubCategoryActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SubCategoryActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface SubCategoryActivitySubcomponent extends AndroidInjector<SubCategoryActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SubCategoryActivity> {}
  }
}
