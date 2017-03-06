package com.lifecycletests.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lifecycletests.behaviors.Behavior;

public abstract class ABaseBehavior implements Behavior<ABaseActivity, ABaseFragment> {

  @Override
  public Intent onNewActivityInstance(String name, Context context) {
    Intent intent = new Intent(context, ABaseActivity.class);
    intent.putExtra(EXTRA_ARGS_KEY, this);
    intent.putExtra(EXTRA_ARGS_NAME, name);
    return intent;
  }

  @Override
  public ABaseFragment onNewFragmentInstance(String name, Context context) {
    Bundle bundle = new Bundle();
    bundle.putSerializable(EXTRA_ARGS_KEY, this);
    bundle.putString(EXTRA_ARGS_NAME, name);
    ABaseFragment fragment = new ABaseFragment();
    fragment.setArguments(bundle);
    return fragment;
  }

}
